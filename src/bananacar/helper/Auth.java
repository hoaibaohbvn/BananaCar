/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.helper;

import bananacar.model.NguoiDung;
import bananacar.model.PhieuNhapHang;

/**
 *
 * @author USER
 */
public class Auth {
    public static NguoiDung user = null;
    public static PhieuNhapHang pnh = null;
    public static void clearForm(){
        Auth.user = null;
    }
    public static boolean isLogin(){
        return Auth.user != null;
    }
    public static boolean isManager(){
        return Auth.isLogin() && user.isVaiTro();
    }
    public static boolean isMaPN(){
        return Auth.pnh != null;
    }
}
