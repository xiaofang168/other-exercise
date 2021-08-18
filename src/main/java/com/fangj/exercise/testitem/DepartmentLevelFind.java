package com.fangj.exercise.testitem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fangjie
 * @date Created in 下午4:42 2021/8/12.
 */
class Department {

    /**
     * id
     */

    private int id;

    /**
     * parent id
     */

    private int pid;

    /**
     * 名称
     */

    private String name;

    public Department(int id, int pid, String name) {

        this.id = id;

        this.pid = pid;

        this.name = name;

    }

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    public int getPid() {
        return pid;
    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    @Override

    public String toString() {

        return "Department{" +

                "id=" + id +

                ", pid=" + pid +

                ", name='" + name + '\'' +

                '}';

    }

}

/**
 * @author fangjie
 * @date Created in 下午10:01 2021/8/18.
 */
public class DepartmentLevelFind {

    public static void main(String[] args) {

        List<Department> allDepartment = new ArrayList<>();

        Department dep1 = new Department(1, 0, "北京总部");

        Department dep3 = new Department(3, 1, "研发中心");

        Department dep4 = new Department(4, 3, "后端研发组");

        Department dep6 = new Department(6, 4, "后端实习生组");

        Department dep7 = new Department(7, 3, "前端研发组");

        Department dep8 = new Department(8, 1, "产品部");


        allDepartment.add(dep6);

        allDepartment.add(dep7);

        allDepartment.add(dep8);

        allDepartment.add(dep1);

        allDepartment.add(dep3);

        allDepartment.add(dep4);

        List<Department> subDepartments = DepartmentLevelFind.getSub(1, allDepartment);

        for (Department subDepartment : subDepartments) {
            System.out.println(subDepartment);
        }

    }

    /**
     * 根据id，获取所有子部门列表(包括隔代子部门，一直到叶子节点)
     * <p>
     * 要求：不能新增参数，不能增加static变量
     *
     * @param id            节点id
     * @param allDepartment 所有部门
     * @return 返回子部门
     */
    public static List<Department> getSub(int id, List<Department> allDepartment) {
        // 查找第一级的所有孩子
        List<Department> departments = allDepartment.stream().filter(e -> e.getPid() == id).collect(Collectors.toList());
        // 未找到孩子返回
        if (departments.isEmpty()) {
            return departments;
        }

        // 定义存储所有孩子的集合
        List<Department> list = new ArrayList<>(departments);

        // 移除查找到的孩子,减少遍历的节点
        allDepartment.removeAll(departments);

        // 开始逐级遍历存储孩子
        for (Department department : departments) {
            // 继续查找
            list.addAll(getSub(department.getId(), allDepartment));
        }
        return list;
    }

}
