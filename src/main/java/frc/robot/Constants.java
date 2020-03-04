/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.util.Color;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants 
{
    //Command Bindings
        //Drive
            public static final int CB_DRIVE_DRIVEFORWARD_AXIS = 1;
            public static final int CB_DRIVE_TURN_AXIS = 0;
       
        //Feeder  
            public static final int CB_FEEDER_FEEDFORWARD_BUTTON = 3;
            public static final int CB_FEEDER_FEEDBACKWARD_BUTTON = 4;
 
            public static final int CB_FEEDER_FEEDRAISE_BUTTON = 6;
            public static final int CB_FEEDER_FEEDLOWER_BUTTON = 5;
            

            

    //Subsystem Constants
        //OI
            public static final int JS_JOYSTICK_1_PORT = 0;

        //Drivetrain
            public static final int DT_MOTOR_L_B_PORT = 5;
            public static final int DT_MOTOR_L_F_PORT = 2;
            public static final int DT_MOTOR_R_B_PORT = 3;
            public static final int DT_MOTOR_R_F_PORT = 6;

            public static final double DT_SPEED_MULTIPLIER = 1;
            public static final double DT_ROTATION_MULTIPLIER = 1;


        //Feeder
            public static final int FD_MOTOR_1_PORT = 1;
            public static final int FD_MOTOR_2_PORT = 4;

            public static final double FD_SPEED_MULTIPLIER = .5;
        

        //Pneumatics
            public static final int PN_COMPRESSOR_PORT = 0;

            public static final int PN_FEEDER_DOUBLESOLENOID_F = 0;
            public static final int PN_FEEDER_DOUBLESOLENOID_B = 1;
            public static final int PN_COLOURWHEEL_DOUBlESOLENOID_F = 6;
            public static final int PN_COLOURWHEEL_DOUBLESOLENOID_R = 7;

        //Colour Wheel  
            public static final double CW_SPINNER_SPEED = 0.1;
            public static final double CW_BRAKE_TIME = 0.2;  
            public static final int CW_WHEEL = 7;
            public static final int CW_SPINNER_BUTTON = 1;
            public static final int CW_SPINNER_BUTTON2 = 2;
            public static final int CW_DEPLOY_BUTTON = 7;
            public static final int CW_RETRACT_BUTTON = 8;
            // Colours are "swapped" for 90 degree offset. Red<>Blue Green<>Yellow
            public static final Color kRED = ColorMatch.makeColor(0.143, 0.427, 0.429);
            public static final Color kYELLOW = ColorMatch.makeColor(0.197, 0.561, 0.240);
            public static final Color kBLUE = ColorMatch.makeColor(0.561, 0.232, 0.114);
            public static final Color kGREEN = ColorMatch.makeColor(0.361, 0.524, 0.113);
            public static final double CW_SPIN_COUNT=4;
            
            
        //Possible Lifter
            public static final int LI_MOTOR = 7;


}
