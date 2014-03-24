extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE
 debut :
STARTUPCODE

;ouvrePrinc
mov bp,sp
sub sp,10

;ouvrePrinc
mov bp,sp
sub sp,12

;ecrireChaine
.DATA
mess0 DB "c1=$"
.CODE
lea dx,mess0
push dx
call ecrch

;lireEnt
lea dx,[bp-2]
push dx
call lirent

;aLaLigne
call ligsuiv

;ecrireChaine
.DATA
mess1 DB "c3=$"
.CODE
lea dx,mess1
push dx
call ecrch

;lireEnt
lea dx,[bp-6]
push dx
call lirent

;aLaLigne
call ligsuiv

;ecrireChaine
.DATA
mess2 DB "c4=$"
.CODE
lea dx,mess2
push dx
call ecrch

;lireEnt
lea dx,[bp-8]
push dx
call lirent

;aLaLigne
call ligsuiv

;iLoad
push word ptr [bp-6]

;iLoad
push word ptr [bp-8]

;iConst
push word ptr 2

;idiv
pop bx
pop ax
cwd
 idiv bx
push ax

;iadd
pop bx
pop ax
add ax,bx
push ax

;iConst
push word ptr 5

;idiv
pop bx
pop ax
cwd
 idiv bx
push ax

;ecrireEnt
call ecrent

;aLaLigne
call ligsuiv

;iLoad
push word ptr [bp-2]

;iConst
push word ptr 3

;iLoad
push word ptr [bp-2]

;imul
pop bx
pop ax
imul bx
push ax

;iadd
pop bx
pop ax
add ax,bx
push ax

;iConst
push word ptr 10

;isub
pop bx
pop ax
sub ax,bx
push ax

;ecrireEnt
call ecrent

;queue
nop
EXITCODE
End debut
