// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int CONTROLLER_PORT = 2;
    public static final int LF_ID = 4;
    public static final int RF_ID = 1;
    public static final int LB_ID = 3;
    public static final int RB_ID = 2;
    public static final int SHAFT_MOTOR = 5; //When you figure out the id, change it
    public static final int RV_AXIS = 2;//right vertical
    public static final int LV_AXIS = 1;//left vertical
    public static final int RH_AXIS = 3;//right horizontal
    public static final int LH_AXIS = 0;//left horizontal
    public static final int JOYSTICK_PORT = 3;
    public static final int JOYSTICK_Y_AXIS = 1;
    public static final double SHAFT_ROTATIONS_TO_METERS = 12/30 * 0.5;//12 grooves for first gear, 30 for second gear, and 1/2 inch of height for each rotation of second gear
}
