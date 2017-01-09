#include<SoftwareSerial.h>
SoftwareSerial zigbeeSerial(4,5);
SoftwareSerial gsmSerial(2,3);
String nodeData = "000";
char gatewayGps[100];
char gatewayId[100];
char data;
char zigbeeData[100];
int numByte = 0;


void setup() {
  Serial.begin(38400);
  zigbeeSerial.begin(38400);
  gsmSerial.begin(38400);
  gsmSerial.write("AT+GSN\r\n");
  delay(3000);
  
  while(!gsmSerial.available()){
    ;
  }
  char inChar;
  int i = 0;
  while(gsmSerial.available()){
    inChar =  gsmSerial.read();
    if(inChar=='\r' || inChar=='\n'){
      continue;
    }
    
    gatewayId[i] = inChar;
    i++;
    gatewayId[i] = '\0';
  }
 
  
  Serial.println("set up network");
  gsmSerial.write("AT+SAPBR=3,1,APN,m-wap\r\n");
  delay(3000);
  Serial.println("active bearer");
  gsmSerial.write("AT+SAPBR=1,1\r\n");
  delay(3000);
  clearGsmSerialBuffer();
  Serial.println("get location");
  gsmSerial.write("AT+CIPGSMLOC=1,1\r\n");
  while(!gsmSerial.available()){
    ;
  }
  clearGsmSerialBuffer();
  
  
  char inChar2;
  int j = 0;
  while(!gsmSerial.available()){
    ;
  }
  while(gsmSerial.available()){
    inChar2 =  gsmSerial.read();
    if(inChar2=='\r' || inChar2=='\n'){
      continue;
    }
    gatewayGps[j] = inChar2;
    j++;
    gatewayGps[j] = '\0';

  }
  j=0;
  Serial.println(gatewayId);
  Serial.println(gatewayGps);
  Serial.println("init http");
  gsmSerial.write("AT+HTTPINIT\r\n");
  delay(3000);
  /*Serial.println("set URL");
  gsmSerial.write("AT+HTTPPARA=URL,http://apps.iot.uit.edu.vn/gps\r\n");
  delay(3000);
  Serial.println("set content ");
  gsmSerial.write("AT+HTTPPARA=CONTENT,application/json\r\n");
  delay(3000);
  Serial.println("set data ");
  gsmSerial.write("AT+HTTPDATA=2048,5000\r\n");
  delay(3000);
  Serial.println("input data");
  gsmSerial.write("{\"id\": \"");
  gsmSerial.write(gatewayId);
  gsmSerial.write("\", \"gps\": \"");
  gsmSerial.write(gatewayGps);
  gsmSerial.write("\"}\r\n"); 
  delay(3000);
  Serial.println("post gps locaton");
  gsmSerial.write("AT+HTTPACTION=1\r\n");*/
  zigbeeSerial.listen();
  while(!zigbeeSerial.isListening()){
    ;
  }
  Serial.println("post gps completed");

}

void loop() {
  configure();
  delay(1000);
}


void clearBuffer(){
  clearGsmSerialBuffer();
  clearZigbeeSerialBuffer();
}
void clearGsmSerialBuffer(){
   while(gsmSerial.available()){
     gsmSerial.read();
    }
}

void clearZigbeeSerialBuffer(){
   while(zigbeeSerial.available()){
    zigbeeSerial.read();
  }
}

void configure(){
     clearZigbeeSerialBuffer();
     while(!zigbeeSerial.available()){
        ;
     }
     Serial.println("config");
    while(zigbeeSerial.available()){
        data =  zigbeeSerial.read();
        if(data==' '){
          continue;
        }
        zigbeeData[numByte] = data;
        numByte++;
        zigbeeData[numByte] = '\0';
        delay(1);
    }
    numByte = 0;
    Serial.println(zigbeeData); 
    Serial.println("set URL");
    gsmSerial.write("AT+HTTPPARA=URL,http://apps.iot.uit.edu.vn/data\r\n");
    delay(3000);
    Serial.println("set content ");
    gsmSerial.write("AT+HTTPPARA=CONTENT,application/json\r\n");
    delay(3000);
    Serial.println("set data ");
    gsmSerial.write("AT+HTTPDATA=2048,5000\r\n");
    Serial.println("input data");
    delay(3000); 
    gsmSerial.write(zigbeeData);
    delay(3000);
    Serial.println("post ");
    gsmSerial.write("AT+HTTPACTION=1\r\n");
    Serial.println("finish ");
}

