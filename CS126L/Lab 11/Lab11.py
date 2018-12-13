import random


class DiceRoller:
    # A utility class for dice rolling

    def roll(self, times, sides):
        # Rolls times number of sides-sided dice; returns the total
        total = 0
        for i in range(times):
            roll = random.randint(1, sides)
            total += roll
        return total

r = DiceRoller()


class Attack:
    # Encapsulates the concept of an attack

    def __init__(self, name, number_of_die, sides_of_die, damage_type):
        '''Creates an attack with privates attribute

        adds name, sides, number, and type

        to self, with values provided by the arguments
        '''
        self._name = name
        self._sides = sides_of_die
        self._number = number_of_die
        self._type = damage_type

    def get_attack_type(self):
        '''Returns the type of attack, as a string'''
        return self._type

    def get_damage(self):
        '''Returns a damage value for this attack

        Roll number number of sides sided dice, using
        DiceRoller r, and returns the resulting value

        '''

        damage = r.roll(self._number, self._sides)
        return damage
        # Write getters and setters for the rest of the attack class variables


class Adventurer:
    # Encapsulates the concept of an adventure

    def __init__(self, name, hit_points, defence, magic_defence, initiative):
        '''Creates an adventurer with private attributes

        adds name, hit points, defence, magic defence, and initiative to
        self, with values provided by the arguments

        '''

        self._name = name
        self._hit_points = hit_points
        self._defence = defence
        self._magic_defence = magic_defence
        self._initiative = initiative
        self.alive = True
        self.init = 0

    def is_alive(self):
        '''Returns True if this object has more than 0 hit points'''
        if self._hit_points <= 0:
            return False
        else:
            return True

    def roll_initiative(self):
        '''Returns a random integer between 0 and this
         object's initiative value'''
        self.init = r.roll(1, self._initiative)
        return self.init

    def take_damage(self, amount, damage_type):
        '''Applies  damage to this object's attributes'''
        if damage_type == "Physical":
            self.damage_taken = amount - self._defence
        else:
            self.damage_taken = amount - self._magic_defence

        if self.damage_taken <= 0:
            self.damage_taken = 0
        else:
            self._hit_points -= self.damage_taken
    # Write getters and setters for all class variables


class Fighter(Adventurer):
    '''Encapsulates a Fighter class, inheriting from Adventure.'''

    _HP = 40
    _DEF = 10
    _MAG_DEF = 4

    def __init__(self, name, initiative):
        '''Creates a Fighter object.'''

        super().__init__(
            name, Fighter._HP, Fighter._DEF, Fighter._MAG_DEF, initiative)
        self._melee = Attack('Slash', 1, 8, 'Physical')

    def strike(self):
        '''Calculates and
        returns information about physical strike from this object'''
        self.attacking = self._melee.get_damage()
        output = (str(self.attacking), self._melee.get_attack_type())
        return output

    def __str__(self):
        '''Returns a string representing the objact.'''
        return '%s with %s hit points and a Slash attack (1d8)'\
               % (self._name, str(self._hit_points))


class Wizard(Adventurer):
    '''Encapsulates a Wizard class, inheriting from Adventurer

    Wizards have 20 HP, defense of 4, and magic defense of 10, all
    stored as class variables using the same naming conventions as Fighter.

    '''
    _HP = 20
    _DEF = 4
    _MAG_DEF = 10

    def __init__(self, name, initiative):
        '''Creates a Fighter object.'''

        super().__init__(name, Wizard._HP,
                         Wizard._DEF, Wizard._MAG_DEF, initiative)
        self._cast = Attack('FireBall', 3, 6, 'Magic')

    def cast(self):
        '''Calculates and returns
         information about physical strike from this object'''
        self.fireball = self._cast.get_damage()
        output = (self.fireball, self._cast.get_attack_type())
        return output

    def __str__(self):
        '''Returns a string representing the objact.'''

        return '%s with %s hit points and a FireBall attack (3d6)' % \
               (self._name, str(self._hit_points))

if __name__ == '__main__':
    # Create a Fighter object by providing a name and
    # initiative value to the Fighter constructor and print the objact out
    a = Fighter('Aragorn', 20)
    print('Created: ', a)

    # Create a Wizard objact, using the Wizard constructor with similar
    # information as that provided for Fighter, and print the object out

    b = Wizard('Gandalf', 20)
    print('Created: ', b)
    # Create a variable to keep track of the rounds of combat
    rounds = 0
    is_fighting = True
    # As long as both combatants are still alive, keep fighing rounds
    while is_fighting:
        b_hit = ()
        a_hit = ()
        # Roll initiative for both combatants; whichever one has the highest
        a_init = 0
        b_init = 0
        # Inititative gets to attack this round. The other one... sits there
        while a_init == b_init:
            a_init = a.roll_initiative()
            b_init = b.roll_initiative()
        # IF the initiative values are equal,
        # roll them again until one is higher

        # an attack works by getting a
        #  damage value and type by using the cast() or strike()
        if a_init <= b_init:
            a_hit = a.strike()
            print(a_hit)
            b.take_damage(int(a_hit[0]), a_hit[1])
        else:
            b_hit = b.cast()
            print(b_hit)
            a.take_damage(b_hit[0], b_hit[1])
        # method from whatever
        #  object won initiative. Then, call take._damage() on the
        # losing object using the values that cast()/strike() returned

        # Dont forget to increment your round counter
        rounds += 1
        if a.is_alive() and b.is_alive():
            continue
        else:
            is_fighting = False

    # Print out a message indicating which combatant is still alive and their
    if a.is_alive():
        print("%s has won with %s hit points left!" % (a._name, a._hit_points))
    elif b.is_alive():
        print("%s has won with %s hit points left!" % (b._name, b._hit_points))
    else:
        print("everyone dies")
    # remaining hit points
