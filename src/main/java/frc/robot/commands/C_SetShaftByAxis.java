// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SS_Shaft;

public class C_SetShaftByAxis extends CommandBase {
  private final SS_Shaft SS_shaft;
  private final double speedModifier = 0.2;
  /** Creates a new C_ShaftByAxis. */
  public C_SetShaftByAxis(SS_Shaft SS_shaft) {
    this.SS_shaft = SS_shaft;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(SS_shaft);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double axis = DriverStation.getInstance().getStickAxis(Constants.JOYSTICK_PORT, Constants.JOYSTICK_Y_AXIS);
    System.out.println("Shaft Axis: " + axis);
    SS_shaft.setSpeed(axis*speedModifier);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SS_shaft.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
