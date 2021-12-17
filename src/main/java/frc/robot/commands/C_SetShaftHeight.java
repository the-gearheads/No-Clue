// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SS_Shaft;
import frc.robot.commands.C_SetShaftByAxis;

public class C_SetShaftHeight extends CommandBase {
  public final SS_Shaft SS_shaft;
  public final double requestedHeight;
  public final double speed = 0.3;
  /** Creates a new C_SetShaftHeight. */
  public C_SetShaftHeight(SS_Shaft SS_shaft, double height) {
    this.SS_shaft = SS_shaft;
    this.requestedHeight = height;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(SS_shaft.getHeight()<requestedHeight){
      SS_shaft.setSpeed(speed);
    }else{
      SS_shaft.setSpeed(-speed);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if(SS_shaft.getHeight()<requestedHeight){
      
    // }else{
      // SS_shaft.setSpeed(-speed);
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SS_shaft.setSpeed(0);
    (new C_SetShaftByAxis(this.SS_shaft)).schedule(true);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(SS_shaft.getHeight()-requestedHeight) < 0.1;
    // return SS_shaft.getHeight() > requestedHeight;
  }
}
