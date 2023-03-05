sealed interface TrafficLight {}

final class RedLight implements TrafficLight {}
final class YellowLight implements TrafficLight {}
final class GreenLight implements TrafficLight {}
//by default all the implementations are in the same file.

//However, you can use a permits clause to list all the implementations
//that may come from other files in the same package.

//sealed interface TrafficLight permits RedLight, YellowLight, GreenLight, FlashingLight {}
//where FlashingLight may be in another file

