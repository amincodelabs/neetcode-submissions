class MyHashMap {
   private:
    struct ListNode {
        int key, value;
        ListNode* next;
        ListNode(int k, int v) : key(k), value(v), next(nullptr) {}
    };
    vector<ListNode*> data;

    int hash(int key) { return key % data.size(); }

   public:
    MyHashMap() {
        data.resize(1000, nullptr);
        for (auto& bucket : data) {
            bucket = new ListNode(-1, -1);
        }
    }

    void put(int key, int value) {
        ListNode* current = data[hash(key)];
        while (current->next != nullptr) {
            if (current->next->key == key) {
                current->next->value = value;
                return;
            }
            current = current->next;
        }
        current->next = new ListNode(key, value);
    }

    int get(int key) {
        ListNode* current = data[hash(key)]->next;
        while (current != nullptr) {
            if (current->key == key) {
                return current->value;
            }
            current = current->next;
        }
        return -1;
    }

    void remove(int key) {
        ListNode* current = data[hash(key)];
        while (current->next != nullptr) {
            if (current->next->key == key) {
                ListNode* temp = current->next;
                current->next = temp->next;
                delete temp;
                return;
            }
            current = current->next;
        }
    }
};