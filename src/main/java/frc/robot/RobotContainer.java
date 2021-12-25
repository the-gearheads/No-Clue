// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.SS_Drive;
import frc.robot.subsystems.SS_Elevator;
import frc.robot.subsystems.SS_Elevator2;
import frc.robot.subsystems.SS_Claw;
import frc.robot.commands.C_SetClawByPosition;
import frc.robot.commands.C_SetElevatorByAxis;
import frc.robot.commands.C_SetElevatorByHeight;
import frc.robot.commands.C_SetElevatorByHeight2;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private SS_Drive SS_drive;
  // private SS_Elevator SS_elevator;
    private SS_Elevator2 SS_elevator;

  private XboxController controller;
  private SS_Claw SS_claw;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    controller = new XboxController(Constants.CONTROLLER_PORT);
    // SS_drive = new SS_Drive();
    // SS_elevator = new SS_Elevator();
    SS_elevator = new SS_Elevator2();
    // SS_claw = new SS_Claw();
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // JoystickButton yBtn = new JoystickButton(controller, 4);
    // yBtn.whenPressed(new C_SetElevatorByHeight(SS_elevator, 0.5));


    // JoystickButton xBtn = new JoystickButton(controller, 1);
    // xBtn.whenPressed(new C_SetElevatorByHeight(SS_elevator, 0));

    // JoystickButton lTriggerBtn = new JoystickButton(controller, Constants.lTriggerBtn);
    // lTriggerBtn.whenPressed(new C_SetClawByPosition(SS_claw, 0));

    // JoystickButton rTriggerBtn = new JoystickButton(controller, Constants.rTriggerBtn);
    // rTriggerBtn.whenPressed(new C_SetClawByPosition(SS_claw, 50));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
