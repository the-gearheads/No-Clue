// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.OldCode;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.ProfiledPIDCommand;
import frc.robot.Constants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class C_SetElevatorByHeight2 extends ProfiledPIDCommand {
  /** Creates a new C_SetElevatorByHeight2. */
  public C_SetElevatorByHeight2(SS_Elevator SS_elevator, double requestedHeight) {
    super(
        // The ProfiledPIDController used by the command
        new ProfiledPIDController(
            // The PID gains
            Constants.Elevator.kP,
            Constants.Elevator.kI,
            Constants.Elevator.kD,
            // The motion profile constraints
            new TrapezoidProfile.Constraints(Constants.Elevator.MAX_VEL, Constants.Elevator.MAX_ACC)),
        // This should return the measurement
        SS_elevator::getHeight,
        // This should return the goal (can also be a constant)
        requestedHeight,
        // This uses the output
        (output, setpoint) -> {
          // Use the output (and setpoint, if desired) here
          SS_elevator.setVoltage(output);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(SS_elevator);
    // Configure additional PID options by calling `getController` here.
    getController().setTolerance(3);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atGoal();
  }
}
