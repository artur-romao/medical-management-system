import pika
import json

from pika.exceptions import ChannelError

from pika.spec import TRANSIENT_DELIVERY_MODE


connection = pika.BlockingConnection(pika.ConnectionParameters(host='192.xx', port=5672))
channel = connection.channel()
channel.exchange_declare(exchange='logs',exchange_type='direct')
res = channel.queue_declare(queue='',exclusive=True)

msgqueue=res.method.queue
severities = sys.argv[1:]
if not severities:
    sys.stderr.write("Usage: %s [info] [warning] [error]\n" % sys.argv[0])
    sys.exit(1)

for severity in severities:
    channel.queue_bind(
        exchange='logs', queue=msgqueue, routing_key=severity)


def callback(ch,method,properties,body):
     print("[x] %r" % body)
channel.basic_consume(queue=msgqueue,on_message_callback=callback, auto_ack=True)
channel.start_consuming()