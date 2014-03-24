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
sub sp,4

;iConst
push word ptr 8

;iStore
pop ax
mov word ptr [bp-2],ax

;ecrireChaine
.DATA
mess0 DB "c1=$"
.CODE
lea dx,mess0
push dx
call ecrch

;iLoad
push word ptr [bp-2]

;ecrireEnt
call ecrent

;aLaLigne
call ligsuiv

;ecrireChaine
.DATA
mess1 DB "-45=$"
.CODE
lea dx,mess1
push dx
call ecrch

;iConst
push word ptr 2

;ineg
pop ax
not ax 
push ax

;iLoad
push word ptr [bp-2]

;imul
pop bx
pop ax
imul bx
push ax

;iConst
push word ptr 3

;ineg
pop ax
not ax 
push ax

;iConst
push word ptr 4

;imul
pop bx
pop ax
imul bx
push ax

;iConst
push word ptr 2

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
push word ptr 5

;isub
pop bx
pop ax
sub ax,bx
push ax

;ecrireEnt
call ecrent

;aLaLigne
call ligsuiv

;queue
nop
EXITCODE
End debut
