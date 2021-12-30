// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SS_Claw;

public class C_ShutClaw extends CommandBase {
  private SS_Claw SS_claw;
  private double speed = 0.2;

  /** Creates a new C_ShutClaw. */
  public C_ShutClaw(SS_Claw SS_claw) {
    this.SS_claw = SS_claw;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(SS_claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SS_claw.setSpeed(speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SS_claw.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (SS_claw.getCurrent() >= 15) || (SS_claw.getPosition() >= Constants.Claw.CLOSED_POSITION);
  }
}
