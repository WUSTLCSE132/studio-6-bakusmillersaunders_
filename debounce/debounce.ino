const int buttonPin = 2;
int count = 0;
int test = 0;
unsigned long timer = 0;
const int betweenPresses = 100;

void buttonPressed() {
  if (millis() - timer >= betweenPresses){
    count++;
    timer = millis();
  }
}

void setup() {
  pinMode(buttonPin, INPUT_PULLUP);

  // Interrupts can happen on "edges" of signals.  
  // Three edge types are supported: CHANGE, RISING, and FALLING 
  attachInterrupt(digitalPinToInterrupt(buttonPin), buttonPressed, RISING);
  Serial.begin(9600);
}

void loop() {
    if (count > test) {
      Serial.println(count);
      test++;
    }
  }
