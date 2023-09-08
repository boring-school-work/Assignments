package DSA.practice.enums;

public class SomeEnum {
  static enum TrafficLightState {
    RED,
    YELLOW,
    GREEN,
    OFF // there is no state
  }

  static TrafficLightState transition_traffic_light(TrafficLightState state) {
    switch (state) {
      case RED:
        return TrafficLightState.YELLOW;
      case YELLOW:
        return TrafficLightState.GREEN;
      case GREEN:
        return TrafficLightState.RED;
      default:
        return TrafficLightState.OFF;
    }
  }

  static TrafficLightState press_pedestrian_button() {
    return TrafficLightState.RED;
  }

  public static void main(String[] args) {

  }
}
