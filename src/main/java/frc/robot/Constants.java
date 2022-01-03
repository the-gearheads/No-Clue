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
    public final class Controller{
        public static final int PORT = 2;
        public static final int RV_AXIS = 2;//right vertical
        public static final int LV_AXIS = 1;//left vertical
        public static final int RH_AXIS = 3;//right horizontal
        public static final int LH_AXIS = 0;//left horizontal
        public static final int L_TRIGGER = 7;
        public static final int R_TRIGGER = 8;
    }

    public final class Joystick{
        public static final int PORT = 3;
        public static final int Y_AXIS = 1;
    }

    public final class Drive{
        public static final int LF_ID = 4;
        public static final int RF_ID = 1;
        public static final int LB_ID = 3;
        public static final int RB_ID = 2;
    }

    public final class Elevator{
        public static final int MOTOR_ID = 5; //When you figure out the id, change it
        public static final double kP = 1.3956;
        public static final double kI = 0;
        public static final double kD = 0;
        public static final double MAX_VEL = 0;
        public static final double MAX_ACC = 0;
        public static final double kS = 0.64681;
        public static final double kG = 0.67002;
        public static final double kV = 4.8679;
        public static final double kA = 0.24884;
        public static final double MAX_HEIGHT = 0.8;
        public static final double MIN_HEIGHT = 0;
        public static final double AXIS_SPEED = 0.2;//m/s
        public static final double SPEED = 0.2;
        public static final double PID_WEIRD_CONVERSION_FACTOR = 12/30 * 0.01;//The height gained per rotation of shaft is 0.01 (units).
        public static final double ROTATIONS_TO_METERS = (double)30 / 12 * 0.5 * 0.0254*0.5;//12 grooves for first gear, 30 for second gear, and 1/2 inch of height for each rotation of second gear
    }
    public final class Claw{
        public static final int MOTOR_ID = 6;
        public static final double CLOSED_POSITION = 30;
        public static final double OPEN_POSITION = 0;
        public static final double MAX_CURRENT = 10;
    }
}
