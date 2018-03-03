/**
 * @author zhangbj
 * @version 1.0
 * @Type ListNode
 * @Desc
 * @data 2017/10/30
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solutions{
    /*
    * @param head: a ListNode
    * @param val: An integer
    * @return: a ListNode
    */
    public ListNode removeElements(ListNode head, int val) {
        // write your code here
        if(head == null){
            return null;
        }
        ListNode currentNode = head;

        if(currentNode.val == val){
            return this.removeElements(currentNode.next,val);
        }
        return currentNode;
    }
}
