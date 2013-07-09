package org.nlogo.extensions.gogolite.prim

import
  org.nlogo.{ api, extensions },
    api.{ Argument, Context, DefaultReporter, Syntax },
    extensions.gogolite.controller.ControllerManager

class IsOpen(manager: ControllerManager) extends DefaultReporter {
  override def getSyntax = Syntax.reporterSyntax(Syntax.BooleanType)
  override def report(args: Array[Argument], context: Context) = {
    val isOpen = manager.getControllerOpt.flatMap(controller => Option(controller.currentPort)).isEmpty
    Boolean.box(isOpen)
  }
}
