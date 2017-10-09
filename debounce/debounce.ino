void setup(){
  Serial.begin(9600);
}

void loop(){
  if (Serial.available()){
    char myVar = Serial.read();
    Serial.println(myVar);
  }
}

