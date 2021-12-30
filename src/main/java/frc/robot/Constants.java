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
    public static final int ELEVATOR_MOTOR = 5; //When you figure out the id, change it
    public static final int RV_AXIS = 2;//right vertical
    public static final int LV_AXIS = 1;//left vertical
    public static final int RH_AXIS = 3;//right horizontal
    public static final int LH_AXIS = 0;//left horizontal
    public static final int JOYSTICK_PORT = 3;
    public static final int JOYSTICK_Y_AXIS = 1;
    public static final double ELEVATOR_ROTATIONS_TO_METERS = (double)30 / 12 * 0.5 * 0.0254*0.5;//12 grooves for first gear, 30 for second gear, and 1/2 inch of height for each rotation of second gear
    public static final int CLAW_MOTOR = 6;
    public static final int lTriggerBtn = 7;
    public static final int rTriggerBtn = 8;
    public static final double ELEVATOR_kP = 0;
    public static final double ELEVATOR_kI = 0;
    public static final double ELEVATOR_kD = 0;
    public static final double ELEVATOR_MAX_VEL = 0;
    public static final double ELEVATOR_MAX_ACC = 0;
    public static final double CLAW_CLOSED_POSITION = 30;
    public static final double CLAW_OPEN_POSITION = 0;
    public static final double CLAW_MAX_CURRENT = 10;
    public static final double ELEVATOR_kS = 0;
    public static final double ELEVATOR_kG = 0;
    public static final double ELEVATOR_kV = 0;
    public static final double ELEVATOR_kA = 0;
    public static final double ELEVATOR_MAX_HEIGHT = 1;
    public static final double ELEVATOR_MIN_HEIGHT = 0;
    public static final double ELEVATOR_MAX_AXIS_SPEED = 0.05;//0.01 m/s


}
