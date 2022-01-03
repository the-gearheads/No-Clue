// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SS_Elevator;

public class C_SetElevatorByAxis extends CommandBase {
  private double goalPosition = 0;
  private SS_Elevator SS_elevator;
  private double speed = Constants.Elevator.AXIS_SPEED;
  /** Creates a new C_SetElevatorByAxis2. */
  public C_SetElevatorByAxis(SS_Elevator SS_elevator) {
    this.SS_elevator = SS_elevator;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(SS_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double axis = DriverStation.getInstance().getStickAxis(Constants.Joystick.PORT, Constants.Joystick.Y_AXIS);
    double dt = 20/1000; //time per execute() call in seconds 

    if(Math.abs(axis) < 0.02){
      axis = 0;
    }else if(axis>0){
      axis = 1;
    }else{
      axis = -1;
    }

    goalPosition = SS_elevator.getGoal() + axis * speed * dt; 
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
