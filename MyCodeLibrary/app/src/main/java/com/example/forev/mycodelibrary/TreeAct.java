package com.example.forev.mycodelibrary;

import android.util.Log;

import com.example.forev.mycodelibrary.utils.LogUtil;
import com.example.forev.mycodelibrary.utils.RandomDataUtil;

import java.util.Arrays;

public class TreeAct extends BaseActivity {
    private int[] mOriginNumbers;

    private TreeNode mRootNode;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tree;
    }

    @Override
    protected void initView() {
        mOriginNumbers = RandomDataUtil.randomData(10, 100);
        mRootNode = new TreeNode(mOriginNumbers[0]);
        createBinaryTree(mOriginNumbers);
        LogUtil.get().d("原始数据为：" + Arrays.toString(mOriginNumbers));
        LogUtil.get().d(mRootNode.toString());
    }

    private void createBinaryTree(int[] originNumbers) {
        for (int i = 1; i < originNumbers.length; i++) {
            addNode(mOriginNumbers[i], mRootNode);
        }
    }

    private void addNode(int content, TreeNode treeNode) {
        int rootTreeNodeContent = treeNode.content;
        if (content <= rootTreeNodeContent) {
            if (null == treeNode.leftSonNode) {
                treeNode.leftSonNode = new TreeNode(content);
            }  else {
                addNode(content, treeNode.leftSonNode);
            }
        } else {
            if (null == treeNode.rightSonNode) {
                treeNode.rightSonNode = new TreeNode(content);
            } else {
                addNode(content, treeNode.rightSonNode);
            }
        }
    }


    /**
     * tree struct
     */
    private static class TreeNode{
        private TreeNode leftSonNode;
        private TreeNode rightSonNode;
        private int content;

        public void setLeftSonNode(TreeNode leftSonNode) {
            this.leftSonNode = leftSonNode;
        }

        public void setRightSonNode(TreeNode rightSonNode) {
            this.rightSonNode = rightSonNode;
        }

        public void setContent(int content) {
            this.content = content;
        }

        public TreeNode getLeftSonNode() {
            return leftSonNode;
        }

        public TreeNode getRightSonNode() {
            return rightSonNode;
        }

        public int getContent() {
            return content;
        }

        public TreeNode(TreeNode leftSonNode, TreeNode rightSonNode, int content) {
            this.leftSonNode = leftSonNode;
            this.rightSonNode = rightSonNode;
            this.content = content;
        }

        public TreeNode(int content) {
            this.content = content;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"leftSonNode\":")
                    .append(leftSonNode);
            sb.append(",\n\"rightSonNode\":")
                    .append(rightSonNode);
            sb.append(",\n\"content\":")
                    .append(content);
            sb.append('}');
            return sb.toString();
        }
    }

}