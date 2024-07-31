package Controller.HoaDon;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.HoaDon;
import Connection.DButils;
import Connection.MySQLConntUtils;
import java.util.Map;
import java.util.*;

@WebServlet("/HoaDonServlet")
public class HoaDonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String errorString = null;
        List<HoaDon> hoaDonList = new ArrayList<>();

        try {
            Connection con = MySQLConntUtils.getConnection();
            hoaDonList = DButils.selectAllHoaDon(con);
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        // Nhóm theo mã hóa đơn
        Map<Integer, List<HoaDon>> hoaDonMap = new HashMap<>();

        for (HoaDon hoaDon : hoaDonList) {
            int maHoaDon = hoaDon.getMaHoaDon();
            hoaDonMap.computeIfAbsent(maHoaDon, k -> new ArrayList<>()).add(hoaDon);
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("hoaDonMap", hoaDonMap);
        request.getRequestDispatcher("/HoaDon.jsp").forward(request, response);
    }
}

