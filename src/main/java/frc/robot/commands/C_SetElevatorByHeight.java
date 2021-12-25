// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SS_Elevator;
import frc.robot.commands.C_SetElevatorByAxis;

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

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(SS_elevator.getHeight()<requestedHeight){
      SS_elevator.setSpeed(speed);
    }else{
      SS_elevator.setSpeed(-speed);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if(SS_elevator.getHeight()<requestedHeight){
      
    // }else{
      // SS_elevator.setSpeed(-speed);
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SS_elevator.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(SS_elevator.getHeight()-requestedHeight) < 0.02;
    // return SS_elevator.getHeight() > requestedHeight;
  }
}
