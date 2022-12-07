// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.OldCode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class C_SetElevatorByAxis2 extends CommandBase {
  private double goalPosition;
  private SS_Elevator2 SS_elevator;
  private double speed;
  /** Creates a new C_SetElevatorByAxis2. */
  public C_SetElevatorByAxis2(SS_Elevator2 SS_elevator) {
    this.SS_elevator = SS_elevator;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(SS_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    goalPosition = 0;
    speed = Constants.Elevator.AXIS_SPEED;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double axis = DriverStation.getStickAxis(Constants.Joystick.PORT, Constants.Joystick.Y_AXIS);
    double dt = 20/1000; //time per execute() call in seconds 
    goalPosition = goalPosition + axis * speed * dt; 
    SS_elevator.setGoal(goalPosition);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
