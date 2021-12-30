// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SS_Elevator;

public class C_SetElevatorByHeight extends CommandBase {
  private SS_Elevator SS_elevator;
  private double requestedHeight;

  /** Creates a new setElevatorByHeight4. */
  public C_SetElevatorByHeight(SS_Elevator SS_elevator, double requestedHeight) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.SS_elevator = SS_elevator;
    addRequirements(SS_elevator);
    this.requestedHeight = requestedHeight;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SS_elevator.setGoal(requestedHeight);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
