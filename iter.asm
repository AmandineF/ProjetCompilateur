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

;ecrireChaine
.DATA
mess0 DB "n=$"
.CODE
lea dx,mess0
push dx
call ecrch

;lireEnt
lea dx,[bp-6]
push dx
call lirent

;iConst
push word ptr 1

;iStore
pop ax
mov word ptr [bp-4],ax

;iConst
push word ptr 0

;iStore
pop ax
mov word ptr [bp-2],ax

FAIRE1:
;iLoad
push word ptr [bp-4]

;iLoad
push word ptr [bp-6]

;iinfegal
pop bx
pop ax
cmp ax,bx
jg $+6
push -1
jmp $+4
push 0

;iffaux FAIT1
pop ax
cmp ax,0
je FAIT1

;iLoad
push word ptr [bp-2]

;iLoad
push word ptr [bp-4]

;iadd
pop bx
pop ax
add ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-2],ax

;iLoad
push word ptr [bp-4]

;iConst
push word ptr 1

;iadd
pop bx
pop ax
add ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-4],ax

;goto FAIRE1
jmp FAIRE1

FAIT1:
;aLaLigne
call ligsuiv

;ecrireChaine
.DATA
mess1 DB "s=$"
.CODE
lea dx,mess1
push dx
call ecrch

;iLoad
push word ptr [bp-2]

;ecrireEnt
call ecrent

;queue
nop
EXITCODE
End debut
