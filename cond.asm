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
sub sp,6

;lireEnt
lea dx,[bp-2]
push dx
call lirent

;aLaLigne
call ligsuiv

;lireEnt
lea dx,[bp-4]
push dx
call lirent

;aLaLigne
call ligsuiv

;iLoad
push word ptr [bp-4]

;iStore
pop ax
mov word ptr [bp-6],ax

;iLoad
push word ptr [bp-2]

;iLoad
push word ptr [bp-4]

;isup
pop bx
pop ax
cmp ax,bx
jle $+6
push -1
jmp $+4
push 0

;iffaux SINON1
pop ax
cmp ax,0
je SINON1

;iLoad
push word ptr [bp-2]

;iStore
pop ax
mov word ptr [bp-6],ax

;goto FSI1
jmp FSI1

SINON1:
FSI1:

;iLoad
push word ptr [bp-6]

;ecrireEnt
call ecrent

;queue
nop
EXITCODE
End debut
