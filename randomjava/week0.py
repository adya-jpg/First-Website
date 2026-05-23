# this is a basic intoroduction to python.

# you make a comment by using the hash symbol.

#this is a print statement.
print("Hello, World!")

# you can do basic math.
print(2 + 3)
print(5 - 2)
print(4 * 3)
print(8 / 2)

# you can store values in variables.
x = 10
y = 5
print(x + y)

# you can create functions.
def greet(name):
    print("Hello, " + name + "!")
greet("Alice")
greet("Bob")

# you can use loops.
for i in range(5):
    print("Iteration " + str(i))

# you can use conditionals.
age = 18
if age >= 18:
    print("You are an adult.")
else:
    print("You are a minor.")

# you can create lists.
fruits = ["apple", "banana", "cherry"]
for fruit in fruits:
    print(fruit)

# you can create dictionaries.
person = {"name": "Alice", "age": 25}
print("Name: " + person["name"])
print("Age: " + str(person["age"]))

#for more, look at the official Python documentation at: https://docs.python.org/3/.

#ask user for input
name = input("What is your name? ")
print("Hello, " + name + "!")

#ask user for age
age = input("How old are you? ")
print("You are " + age + " years old.")

#ask user for two numbers and add them
num1 = input("Enter a number: ")
num2 = input("Enter another number: ")
sum = float(num1) + float(num2)
print("The sum of " + num1 + " and " + num2 + " is " + str(sum) + ".")

#ask user for a list of items and print them
items = input("Enter a list of items separated by commas: ")
item_list = items.split(",")
print("You entered the following items:")
for item in item_list:
    print(item.strip())

#ask user for a number and check if it's even or odd
number = int(input("Enter a number: "))
if number % 2 == 0:
    print(str(number) + " is even.")
else:
    print(str(number) + " is odd.")

#ask user for a sentence and count the number of words
sentence = input("Enter a sentence: ")
word_count = len(sentence.split())
print("Your sentence has " + str(word_count) + " words.")

#ask user for a temperature in Celsius and convert it to Kelvin
celsius = float(input("Enter temperature in Celsius: "))
kelvin = celsius + 273.15
print(str(celsius) + " degrees Celsius is " + str(kelvin) + " Kelvin.")

#ask user for radius of a circle and calculate area
radius = float(input("Enter the radius of a circle: "))
area = 3.14159 * radius * radius
print("The area of a circle with radius " + str(radius) + " is " + str(area) + ".")