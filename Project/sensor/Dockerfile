FROM python:3.8

COPY requirements.txt ./

ADD gen.py /

ADD recv.py /

RUN pip install -r requirements.txt

CMD ["python3", "gen.py" ]