// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SS_Claw;

public class C_SetClawByPosition extends CommandBase {
  private SS_Claw SS_claw;
  private double speed = 0.2;
  private double requestedPosition;

  /** Creates a new C_SetClawByPosition. */
  public C_SetClawByPosition(SS_Claw SS_claw, double requestedPosition) {
    this.SS_claw = SS_claw;
    this.requestedPosition = requestedPosition;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(SS_claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    updateSpeed();
  }

  private void updateSpeed(){
    if(SS_claw.getPosition()<requestedPosition){
      SS_claw.setSpeed(speed);
    }else{
      SS_claw.setSpeed(-speed);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if((requestedPosition-SS_claw.getPosition())*SS_claw.getSpeed() < 0){
      updateSpeed();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SS_claw.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(requestedPosition - SS_claw.getPosition()) < 0.3
        || (SS_claw.getPosition() >= Constants.Claw.CLOSED_POSITION && speed > 0)
        || (SS_claw.getPosition() <= Constants.Claw.OPEN_POSITION && speed < 0);
        // || SS_claw.getCurrent()  >= Constants.CLAW_MAX_CURRENT;
  }
}
