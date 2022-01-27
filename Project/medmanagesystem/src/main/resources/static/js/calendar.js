  async function callAPI () {
    return new Promise((resolve, reject)=>{
      var http = new XMLHttpRequest();
      http.open("GET", "/consultas/getconsultas", true);
      http.addEventListener("readystatechange", function() {
          if (http.readyState === 4 && http.status === 200) {
            resolve(http.responseText)
          }
      });
      http.send();
    })
  }
  $(async function create_calendar() {

    /* initialize the external events
     -----------------------------------------------------------------*/
    function ini_events(ele) {
      ele.each(function () {

        // create an Event Object (https://fullcalendar.io/docs/event-object)
        // it doesn't need to have a start or end
        var eventObject = {
          title: $.trim($(this).text()) // use the element's text as the event title
        }

        // store the Event Object in the DOM element so we can get to it later
        $(this).data('eventObject', eventObject)

        // make the event draggable using jQuery UI
        $(this).draggable({
          zIndex        : 1070,
          revert        : true, // will cause the event to go back to its
          revertDuration: 0  //  original position after the drag
        })

      })
    }

    ini_events($('#external-events div.external-event'))

    /* initialize the calendar
     -----------------------------------------------------------------*/
    //Date for the calendar events (dummy data)
    var date = new Date()
    var d    = date.getDate(),
        m    = date.getMonth(),
        y    = date.getFullYear(),
        wk   = date.getDay()
    console.log(d, m, y, wk);

    var Calendar = FullCalendar.Calendar;
    var Draggable = FullCalendar.Draggable;

    var containerEl = document.getElementById('external-events');
    var checkbox = document.getElementById('drop-remove');
    var calendarEl = document.getElementById('calendar');

    // initialize the external events
    // -----------------------------------------------------------------

    new Draggable(containerEl, {
      itemSelector: '.external-event',
      eventData: function(eventEl) {
        return {
          title: eventEl.innerText,
          backgroundColor: window.getComputedStyle( eventEl ,null).getPropertyValue('background-color'),
          borderColor: window.getComputedStyle( eventEl ,null).getPropertyValue('background-color'),
          textColor: window.getComputedStyle( eventEl ,null).getPropertyValue('color'),
        };
      }
    });
    var events = JSON.parse((await callAPI())).map(consulta=>{
      return {
        title          : consulta.paciente.pessoa.name,
        start          : new Date(consulta.data),
        allDay         : false,
        backgroundColor: '#3E899A',
        borderColor    : '#3E899A',
        id             : consulta.id
      }
    })
    var calendar = new Calendar(calendarEl, {
      headerToolbar: {
        left  : 'prev,next today',
        center: 'title',
        right : 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      themeSystem: 'bootstrap',
      //Random default events
      events: [
        ...events,
      ],
      editable  : true,
      droppable : true, // this allows things to be dropped onto the calendar !!!
      drop      : function(info) {
        // is the "remove after drop" checkbox checked?
        if (checkbox.checked) {
          // if so, remove the element from the "Draggable Events" list
          info.draggedEl.parentNode.removeChild(info.draggedEl);
        }
      }
    });

    calendar.render();
    // $('#calendar').fullCalendar()
    
    var consulta = document.querySelectorAll("a.fc-daygrid-event")
    for (let i = 0; i < consulta.length; i++) {
      consulta[i].addEventListener("click", event => {
        var paciente = event.target.closest("a.fc-daygrid-event").querySelector(".fc-event-title").innerText
        let foundEvent = events.find(e => e.title === paciente)
        window.location.href="/consulta/" + foundEvent.id
      })
    }
  })
