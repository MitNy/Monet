#include <iostream>
#include <string>

//Boost libraries
#include <boost/shared_ptr.hpp>
#include <boost/make_shared.hpp>

//Thrift libraries
#include <thrift/protocol/TBinaryProtocol.h>             
#include <thrift/server/TSimpleServer.h>
#include <thrift/transport/TSocket.h>                    
#include <thrift/transport/TBufferTransports.h>          
#include <thrift/transport/TTransportUtils.h>

//Including the thrift generated files 
#include "DEManagement.h"
#include "kuber_types.h"
#include "kuber_constants.h"

//Namespaces
using namespace apache::thrift;
using namespace apache::thrift::protocol;
using namespace apache::thrift::transport;
using boost::make_shared;
using namespace kuber;

//So far pretty much the same as the server 

int main() {
    //Bolier plate code to create the networking connection with the server
    ::apache::thrift::stdcxx::shared_ptr<TTransport> socket(new TSocket("192.168.138.133", 9090));
    ::apache::thrift::stdcxx::shared_ptr<TTransport> transport(new TBufferedTransport(socket));
    ::apache::thrift::stdcxx::shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport));
   
    DEManagementClient client(protocol);
    
    try{
    
    transport->open();
    
    client.add_dmEngine("imagetest","pure_ftp.tar",8080);

    transport->close();
    }catch (TException &tx){
      std::cout<<"Error: " <<tx.what() <<std::endl;
    }
    return 0;
}

