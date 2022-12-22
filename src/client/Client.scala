package client

import machine._
import automaticTester.TestAvatar

object Client extends App {
	TestAvatar.check(MachineImpl)

}
