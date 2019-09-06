package com.example.aleksav.memoreminderapp;

import java.util.LinkedList;
import java.util.Date;

public class MemoApi {

    static LinkedList<Memo> memoList = new LinkedList<>();

    public static LinkedList<Memo> getMemos(){
        return memoList;
    }

    public static int getLastMemoId() {

        int id;
        LinkedList<Memo> tmpList = getMemos();
        if (tmpList.isEmpty()) {
            id = 1;
        }
        else {
            id = tmpList.getLast().id + 1;
        }
        return id;
    }

    public static void addTestMemos() {
        memoList.add(new Memo(1,"Kupi hleb", "Treba kupiti hleb",Memo.PRIORITY.MEDIUM, false, "2019-3-4"));

    }

    public static void putMemo(Memo memo) {
        memoList.add(memo);
    }

    public static void deleteList() {
        while (!memoList.isEmpty()) {
            memoList.removeFirst();
        }
    }
}
