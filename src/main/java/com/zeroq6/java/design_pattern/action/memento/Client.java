package com.zeroq6.java.design_pattern.action.memento;


/**
 * 备忘录模式的英文原话是:
 * Without violating encapsulation, capture and externalize an object's internal state so that the object can be restored to this state later.
 *   意思是:在不破坏封装性的前提下，捕获一个对象的内部状态，并
 * 在该对象之外保存这个状态。这样，以后就可以将该对象恢复到原先保
 * 存的状态。
 *
 * ■ 发起人(Originator)角色:该角色记录当前时刻的内部状 态，负责定义哪些属于备份范围的状态，负责创建和恢复备忘 数据。
 *          ----需要被备份的对象（该对象的某些属性等需要备份），提供获取当前状态备忘录对象和传入备忘录恢复的方法
 * ■ 备忘录(Memento)角色:该角色负责存储发起人角色的内部 状态，在需要时提供发起人需要的内部状态数据。----备忘录对象
 * ■ 负责人(Caretaker)角色:该角色对备忘录角色进行管理、保 存和提供备忘录。----储存新备忘录对象，获取老的备忘录对象
 */
public class Client {

    public static void main(String[] args) {
        //
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        originator.setState("1");
        originator.showState();
        caretaker.add(originator.backupStateToMemento());
        System.out.println("--------------");
        originator.setState("2");
        originator.showState();
        System.out.println("--------------");
        originator.restoreStateFromMemento(caretaker.get(0));
        originator.showState();

    }
}
