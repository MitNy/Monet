import time
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer
from thrift.Thrift import TException

import ping_pong.ping_pong

socket = TSocket.TSocket('localhost', 9090)
transport = TTransport.TBufferedTransport(socket)
protocol = TBinaryProtocol.TBinaryProtocol(transport)
client = ping_pong.ping_pong.Client(protocol)


while (1):
    try:
        transport.open()
        print "ping"
        print client.ping()
        transport.close()
        time.sleep(1)
    except TException, tx:
        print "%s" % (tx.message)
