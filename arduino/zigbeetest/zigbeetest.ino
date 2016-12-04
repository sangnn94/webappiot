
#include <SoftwareSerial.h>
SoftwareSerial zigbeeSerial(2,3);
void setup() {
  // put your setup code here, to run once:
  zigbeeSerial.begin(38400);
  Serial.begin(38400);

}

void loop() {
  // put your main code here, to run repeatedly:
  if(Serial.available()){
    zigbeeSerial.write(Serial.read());
  }
 /* if(zigbeeSerial.available()){
    Serial.write(zigbeeSerial.read());
  } */
}
