#include<SoftwareSerial.h>
SoftwareSerial zigbeeSerial(4,5);
SoftwareSerial gsmSerial(2,3);
String nodeData = "000";

void setup() {
  Serial.begin(38400);
  zigbeeSerial.begin(38400);
  gsmSerial.begin(38400);
  gsmSerial.write("AT+GSN\r\n");
  delay(3000);
  int a = gsmSerial.available();
  char gatewayId[a];
  char inChar;
  for(int i = 0; i < a; i++){
    inChar =  gsmSerial.read();
    gatewayId[i] = inChar;
    gatewayId[i+1] = '\0';
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
  
  char gatewayGps[1000];
  char inChar2;
  int i = 0;
    
  while(gsmSerial.available()){
    inChar2 =  gsmSerial.read();
    gatewayGps[i] = inChar2;
    i++;
    gatewayGps[i] = '\0';
   } 
  i = 0;
   
  while(!gsmSerial.available()){
    ;
  }
  while(gsmSerial.available()){
    inChar2 =  gsmSerial.read();
    gatewayGps[i] = inChar2;
    i++;
    gatewayGps[i] = '\0';

  }
  Serial.write(gatewayId);
  Serial.write(gatewayGps);
  Serial.println("init http");
  gsmSerial.write("AT+HTTPINIT\r\n");
  delay(3000);
  Serial.println("set URL");
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
  gsmSerial.write("jjjjj");
  gsmSerial.write("\", \"address\": \"");
  gsmSerial.write("cccc");
  gsmSerial.write("\"}\r\n"); 
  delay(3000);//reset deo, tu vpn toi reset di re cc nhanh di ngu la sao?? deo biet luon :|chay lai lan nua c
  Serial.println("post gps locaton");
  gsmSerial.write("AT+HTTPACTION=1\r\n");
  /*zigbeeSerial.listen();
  while(!zigbeeSerial.isListening()){
    ;
  }*/

}
void clearBuffer(){
  clearGsmSerialBuffer();
  clearZigbeeSerialBuffer();
}
void clearGsmSerialBuffer(){
   while(gsmSerial.available()){
     gsmSerial.read();
     // cho nay read de cut bot phan AT+SAPBR=1,1 + OK ,... 
  }
}

void clearZigbeeSerialBuffer(){
   while(zigbeeSerial.available()){
    zigbeeSerial.read();
  }
}
void loop() {
  //configure();
  if(gsmSerial.available()){ 
    
   Serial.write(gsmSerial.read());
    
  }// ko co cai nay sao coi
 
}

void configure(){
    if(zigbeeSerial.available()){
      Serial.println("set URL");
      gsmSerial.write("AT+HTTPPARA=URL,http://webappiot-openshift-web-app-iot.44fs.preview.openshiftapps.com/gps\r\n");
      delay(3000);
      Serial.println("set content ");
      gsmSerial.write("AT+HTTPPARA=CONTENT,application/json\r\n");
      delay(3000);
      Serial.println("set data ");
      gsmSerial.write("AT+HTTPDATA=2048,5000\r\n");
      Serial.println("input data");
      delay(3000); 
      nodeData = zigbeeSerial.readString();
      Serial.println("CO = " + nodeData + " ppm");
      gsmSerial.write("{\"id\": \"ATD+GSN0932484056\", \"nodeID\": \"2\", \"value\": \"");
      while(zigbeeSerial.available()){
        gsmSerial.write(zigbeeSerial.read());
      }
      gsmSerial.write("\", \"date\":\"date test\"}\r\n");
      delay(3000);
      Serial.println("post ");
      gsmSerial.write("AT+HTTPACTION=1\r\n");
      Serial.println("finish ");
    }
}

