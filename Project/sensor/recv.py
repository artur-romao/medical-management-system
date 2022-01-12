import pika
import json
import sys

from pika.exceptions import ChannelError

from pika.spec import TRANSIENT_DELIVERY_MODE


connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost', port=5672))
channel = connection.channel()
channel.queue_declare(queue='oxi')
channel.queue_declare(queue='hb')
channel.queue_declare(queue='temp')
channel.queue_declare(queue='pressao_arterial')
#msgqueue=res.method.queue
#severities = sys.argv[1:]
#if not severities:
#    sys.stderr.write("Usage: %s [info] [warning] [error]\n" % sys.argv[0])
#    sys.exit(1)
#
#for severity in severities:
#    channel.queue_bind(
#        exchange='logs', queue=msgqueue, routing_key=severity)


def callback(ch,method,properties,body):
     print("[x] %r" % body)
channel.basic_consume(queue='oxi', on_message_callback=callback, auto_ack=True)
channel.basic_consume(queue='hb', on_message_callback=callback, auto_ack=True)
channel.basic_consume(queue='temp', on_message_callback=callback, auto_ack=True)
channel.basic_consume(queue='pressao_arterial', on_message_callback=callback, auto_ack=True)


print(' [*] Waiting for messages. To exit press CTRL+C')
channel.start_consuming()