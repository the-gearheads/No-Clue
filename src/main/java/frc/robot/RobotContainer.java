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
import frc.robot.subsystems.SS_Claw;
import frc.robot.commands.C_SetClawByPosition;
import frc.robot.commands.C_SetElevatorByHeight;
import frc.robot.commands.C_ShutClaw;
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
  private SS_Elevator SS_elevator;

  private XboxController controller;
  private Joystick joystick;
  private SS_Claw SS_claw;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    controller = new XboxController(Constants.Controller.PORT);
    joystick = new Joystick(Constants.Joystick.PORT);
    SS_drive = new SS_Drive();
    SS_elevator = new SS_Elevator();
    SS_claw = new SS_Claw();
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  // Joystick joystick = new Joystick(C)
  private void configureButtonBindings() {
    JoystickButton btn1 = new JoystickButton(joystick, 1);
    btn1.whenPressed(new C_SetElevatorByHeight(SS_elevator, 0.8));

    JoystickButton btn2 = new JoystickButton(joystick, 2);
    btn2.whenPressed(new C_SetElevatorByHeight(SS_elevator, 0));

    JoystickButton btn3 = new JoystickButton(joystick, 3);
    btn3.whenPressed(new C_ShutClaw(SS_claw));

    JoystickButton btn4 = new JoystickButton(joystick, 4);
    btn4.whenPressed(new C_SetClawByPosition(SS_claw, 0));

    JoystickButton btn5 = new JoystickButton(joystick, 5);
    btn5.whenPressed(new C_SetClawByPosition(SS_claw, 20));
    
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
