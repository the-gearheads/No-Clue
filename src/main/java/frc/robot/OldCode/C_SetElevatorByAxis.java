// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.OldCode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class C_SetElevatorByAxis extends CommandBase {
  private final SS_Elevator SS_elevator;
  private final double speedModifier = 0.2;
  /** Creates a new C_ShaftByAxis. */
  public C_SetElevatorByAxis(SS_Elevator SS_elevator) {
    this.SS_elevator = SS_elevator;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(SS_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double axis = DriverStation.getStickAxis(Constants.Joystick.PORT, Constants.Joystick.Y_AXIS);
    // System.out.println("Shaft Axis: " + axis);
    SS_elevator.setSpeed(axis*speedModifier);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SS_elevator.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
