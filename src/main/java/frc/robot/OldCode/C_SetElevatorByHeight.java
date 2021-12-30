// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.OldCode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class C_SetElevatorByHeight extends CommandBase {
  public final SS_Elevator SS_elevator;
  public final double requestedHeight;
  public final double speed = 0.3;
  /** Creates a new C_SetelevatorHeight. */
  public C_SetElevatorByHeight(SS_Elevator SS_elevator, double height) {
    this.SS_elevator = SS_elevator;
    this.requestedHeight = height;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(SS_elevator);
  }

  @Override
  public void initialize() {
    updateSpeed();
  }

  private void updateSpeed(){
    if(SS_elevator.getHeight()<requestedHeight){
      SS_elevator.setSpeed(speed);
    }else{
      SS_elevator.setSpeed(-speed);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if((requestedHeight-SS_elevator.getHeight())*SS_elevator.getSpeed() < 0){
      updateSpeed();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SS_elevator.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(requestedHeight - SS_elevator.getHeight()) < 0.005
        || SS_elevator.getHeight() >= Constants.Elevator.MAX_HEIGHT
        || SS_elevator.getHeight() <= Constants.Elevator.MIN_HEIGHT;
  }
}
