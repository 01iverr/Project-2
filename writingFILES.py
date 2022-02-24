import random
#open a (new) file to write
k=0
while k<10:
    name= "d"+str(k)+".txt"
    outF = open(name, "w")
    i=0
    if i==0:
        i=i+1
        outF.write("27")
        outF.write("\n")
    if i==1:
        i=i+1
        outF.write("750")
        outF.write("\n")
    i=i-2
    while i<750:
        outF.write(str(i+1))
        outF.write(" ")
        randomnumber = random.randint(1, 3000)
        outF.write(str(randomnumber))
        outF.write("\n")
        i=i+1

    k+=1
    outF.close()
