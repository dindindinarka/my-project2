package 566.566.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import 566.566.cases._

object CommonScenario {
  def apply(): ScenarioBuilder = new CommonScenario().scn
}

class CommonScenario {

  val scn: ScenarioBuilder = scenario("Common Scenario")
    .exec(GetMainPage.getMainPage)

}
