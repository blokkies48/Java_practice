#isPerfectNumber(6); //should return true since its proper divisors are 1, 2, 3 and the sum is 1 + 2 + 3 = 6
#
#isPerfectNumber(28); //should return true since its proper divisors are 1, 2, 4, 7, 14 and the sum is 1 + 2 + 4 + 7 + 14 = 28
#
#isPerfectNumber(5); //should return false since its only proper divisor is 1 and the sum is 1 not 5
#
#isPerfectNumber(-1); //should return false since the number is < 1

def is_perfect_number(number : int):
    if number < 0: return False;
    factors : int = 0;
    for i in range(1,number): 
        if number % i == 0: factors += i;
    return factors == number;

print(is_perfect_number(6)); # True
print(is_perfect_number(28)); # True
print(is_perfect_number(5)); # False
print(is_perfect_number(-1)); # False