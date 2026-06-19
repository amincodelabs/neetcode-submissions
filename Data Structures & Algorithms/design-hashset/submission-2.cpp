class MyHashSet {
   private:
    struct ListNode {
        int value;
        ListNode* next;
        ListNode(int val) : value(val), next(nullptr) {}
    };

    vector<ListNode*> data;
    int hash(int key) { return key % data.size(); }

   public:
    MyHashSet() {
        data.resize(10000);
        for (auto& bucket : data) {
            bucket = new ListNode(0);
        }
    }

    void add(int key) {
        ListNode* current = data[hash(key)];
        while (current->next != nullptr) {
            if (current->next->value == key) {
                return;
            }
            current = current->next;
        }
        current->next = new ListNode(key);
    }

    void remove(int key) {
        ListNode* current = data[hash(key)];
        while (current->next != nullptr) {
            if (current->next->value == key) {
                ListNode* temp = current->next;
                current->next = temp->next;
                delete temp;
                return;
            }
            current = current->next;
        }
    }

    bool contains(int key) {
        ListNode* current = data[hash(key)];
        while (current->next) {
            if (current->next->value == key) {
                return true;
            }
            current = current->next;
        }
        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */