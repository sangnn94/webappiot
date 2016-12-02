
byte pinMQ = A0;
boolean alarmCO = false;
// Adjust vRef to be the true supply voltage in mV.
float vRef = 5000.0;
float RL = 10.0;  //  load resistor value in k ohms
float ratioRsRo = 10.0;  //  default value 10 k ohms.  Revised during calibration.
const float Ro_clean_air_factor = 10.0;

float mV = 0.0;
unsigned long samples = 0;

void setup() {
  Serial.begin(9600);
  while (!Serial) {
    ; 
  }
  Serial.println("  ");
  Serial.println("Calibrating MQ-7 CO sensor in clean air..");
  Serial.println("  60 sec high heat cycle..");
  Serial.println("  60 sec warmup complete");
  Serial.println("  90 sec heat cycle..");
  Serial.println("  90 sec warmup complete.  Reading MQ-7..");
   
}

void loop() {
  
  getData();
  delay(1000);
  
}

void getData(){
  mV = 0.0;
  samples = 0.0;
  for(int i = 300; i>0; i--){
    mV += Get_mVfromADC(pinMQ);
    samples += 1;
    delay(10);
  }
  mV = mV / (float) samples;
  Serial.print("  avg A");
  Serial.print(pinMQ);
  Serial.print(" for ");
  Serial.print(samples);
  Serial.print(" samples = ");
  Serial.print(mV);
  Serial.println(" mV");
  Serial.print("  Rs = ");
  Serial.println(CalcRsFromVo(mV));
  ratioRsRo = CalcRsFromVo(mV) / Ro_clean_air_factor;
  Serial.print("  Rs/Ro = ");
  Serial.println(ratioRsRo);
  Serial.print("  CO = ");
  Serial.println(GetCOPpmForRatioRsRo(ratioRsRo));
  Serial.println("Sensor calibration in clean air complete");
  Serial.println("Setup complete.  Monitoring for CO..");
  Serial.println("  ");
}

float CalcRsFromVo(float Vo) {
  //  Vo = sensor output voltage in mV.
  //  VRef = supply voltage, 5000 mV
  //  RL = load resistor in k ohms
  //  The equation Rs = (Vc - Vo)*(RL/Vo)
  float Rs = (vRef - Vo) * (RL / Vo);  
  return Rs;
}

float GetCOPpmForRatioRsRo(float RsRo_ratio) {
  //  for the curve of:  Rs/Ro = 22.073 * (CO ppm) ^ -0.66659
  float ppm;
  ppm = pow((RsRo_ratio/22.073), (1/-0.66659));
  return  ppm;
}

float Get_mVfromADC(byte AnalogPin) {
    // read the value from the sensor:
    int ADCval = analogRead(AnalogPin);  
    float mV = ADCval * (vRef / 1024.0);
    return mV;
}

   

  
