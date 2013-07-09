package org.nlogo.extensions.gogolite.prim

import
  org.nlogo.{ api, extensions },
    api.{ Argument, Context, Syntax },
    extensions.gogolite.controller.{ Controller, ControllerManager }

class OutputPortPower(manager: ControllerManager) extends ManagedCommand(manager) {
  override def getSyntax = Syntax.commandSyntax(Array(Syntax.NumberType))
  override def managedPerform(args: Array[Argument], context: Context, controller: Controller) {
    controller.setOutputPortPower(args(0).getIntValue)
  }
}
