def can_pack(big_count:int, small_count:int, goal:int):
    if big_count < 0 or small_count < 0 or goal < 0: return False;

    big_weight = big_count * 5;
    sum_weight = small_count * big_weight
    if big_weight == goal: return True;
    elif sum_weight >= goal:
        if big_weight > goal:
            remainder = goal % 5;
            if remainder > small_count: return False;
        return True;
    return False;


print(can_pack(2, 1, 5)) # True
print(can_pack(4, 18, 19)) # True
print(can_pack(5, 3, 24)) # False
print(can_pack(6, 2, 17)) # True
