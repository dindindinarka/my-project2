package 566.566

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations
import 566.566.scenarios.CommonScenario

class MaxPerformance extends Simulation with Annotations {

  setUp(
    CommonScenario().inject(
      incrementUsersPerSec((intensity / stagesNumber).toInt) // интенсивность на ступень
        .times(stagesNumber)                                 // Количество ступеней
        .eachLevelLasting(stageDuration)                     // Длительность полки
        .separatedByRampsLasting(rampDuration)               // Длительность разгона
        .startingFrom(0),                                    // Начало нагрузки с
    ),
  ).protocols(httpProtocol)
    .maxDuration(testDuration)                               // общая длительность теста

}
